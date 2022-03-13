package com.chandrasapplication.app.extensions

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.chandrasapplication.app.R
import com.chandrasapplication.app.appcomponents.di.MyApp
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

public object PickerHandler {
    public const val REQUEST_PERMISSION: Int = 10

    public const val OPEN_CAMERA_REQUEST_CODE: Int = 1

    public const val OPEN_STORAGE_REQUEST_CODE: Int = 2

    public const val OPEN_CONTACT_REQUEST_CODE: Int = 3

    public const val MIME_TYPE_IMAGE: String = "image/*"

    public const val MIME_TYPE_ALL: String = "*/*"

    public fun filePickerIntent(mimeType: String = MIME_TYPE_ALL): Intent {
        val pickFile = Intent(Intent.ACTION_GET_CONTENT)
        pickFile.type = mimeType
        return pickFile
    }

    public fun takePictureFromCameraIntent(imageUri: Uri? = null): Intent {
        val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (imageUri!=null) {
                takePicture.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        }
        return takePicture
    }

    public fun contactIntent(): Intent {
        val openContacts = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        return openContacts
    }

    public fun getContactInfo(contactData: Uri, context: Context): Unit {
        var cursor: Cursor? = context.contentResolver.query(contactData!!,null,null,null,null)
        cursor?.moveToFirst()
        var checkPhoneNo:String =
                cursor!!.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.HAS_PHONE_NUMBER))
        var getContactId:String =
                cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
        if (checkPhoneNo.equals("1")) {
            var phones: Cursor? =
                    context.contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + getContactId,
                    null, null)
            while (phones!!.moveToNext()) {
                var number =
                        phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                var name =
                        phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                Log.v("ContactNo --- Name", ">>>$number --- $name")
            }
            phones.close()
        } else {
            Toast.makeText(context,R.string.msg_this_contact_has_no_phone_nu,
                    Toast.LENGTH_LONG).show()
        }
        cursor.close()
    }

    public fun isValidCameraIntent(takePicture: Intent): Boolean =
            takePicture.resolveActivity(MyApp.getInstance().packageManager)!= null ||
    MyApp.getInstance().packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)

    public fun createUri(context: Context?): Uri? {
            val title = "title"
            val values = ContentValues()
            values.put(MediaStore.Images.Media.TITLE, title)
            return context?.contentResolver?.insert(
                                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                    values
                                )
    }
}
