package com.example.siwo.Dekorasi

import ApiMain
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.siwo.R
import com.example.siwo.Response.Respon
import kotlinx.android.synthetic.main.activity_tambah_dekorasi.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class TambahDekorasiActivity : AppCompatActivity() {
    private var uriImage: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_dekorasi)
        checkPermission()


        btnGambarDekorasi1.setOnClickListener{
            pilihFoto()
        }

        btnUploadDekorasi.setOnClickListener{
            val nama_dekorasi = etNamaDekorasi.text.toString()
            val harga_dekorasi = etHargaDekorasi.text.toString()
            val deskripsi_dekorasi = etDeskripsiDekorasi.text.toString()

            if(nama_dekorasi.isEmpty()){
                etNamaDekorasi.setError("Nama Dekorasi Tidak Boleh Kosong")
            }else if(harga_dekorasi.isEmpty()){
                etHargaDekorasi.setError("Harga Tidak Boleh Kosong")
            }else if(deskripsi_dekorasi.isEmpty()){
                etDeskripsiDekorasi.setError("Tidak Boleh Kosong")
            }else{
                val file = File(getPath(uriImage!!))
                val reqFile = RequestBody.create(MediaType.parse("image/*"), file)
                val body = MultipartBody.Part.createFormData("filefoto1", file.name, reqFile)

                Toast.makeText(this@TambahDekorasiActivity, body.toString(), Toast.LENGTH_SHORT).show()

                val call = ApiMain().services.addDekorasi(nama_dekorasi, harga_dekorasi, deskripsi_dekorasi, body)
                call.enqueue(object : Callback<Respon>{
                    override fun onResponse(call: Call<Respon>, response: Response<Respon>) {
                        Toast.makeText(this@TambahDekorasiActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<Respon>, t: Throwable) {
                        Toast.makeText(this@TambahDekorasiActivity, t.message, Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }


    fun pilihFoto(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Buka Galeri"),
            IMAGE_PICK_CODE
        )
    }



    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission enable", Toast.LENGTH_SHORT).show()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun getPath(uri: Uri):String{
        var cursor = contentResolver.query(uri, null, null, null,null)
        cursor!!.moveToFirst()
        var document_id = cursor.getString(0)
        document_id=document_id.substring(document_id.lastIndexOf(":")+1)
        cursor.close()

        cursor= contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null,
            MediaStore.Images.Media._ID+" =? ",
            arrayOf(document_id), null
        )

        cursor!!.moveToFirst()
        val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()

        return path
    }

    fun checkPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_DENIED){
                //permission denied
                val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                //show popup to request runtime permission
                requestPermissions(permissions,
                    PERMISSION_CODE
                );
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode== IMAGE_PICK_CODE && resultCode == Activity.RESULT_OK){
            Toast.makeText(this, "berhasil", Toast.LENGTH_SHORT).show()
            uriImage=data?.data
            btnGambarDekorasi1.setImageURI(data?.data)
        } else {
            Toast.makeText(this, "gagal" , Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        //image pick code
        private var IMAGE_PICK_CODE = 1000
        //Permission code
        private var PERMISSION_CODE = 1001
    }
}
