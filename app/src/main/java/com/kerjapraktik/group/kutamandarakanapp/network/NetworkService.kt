package com.kerjapraktik.group.kutamandarakanapp.network

import com.kerjapraktik.group.kutamandarakanapp.login.data.ResultLogin
import com.kerjapraktik.group.kutamandarakanapp.model.*
import com.kerjapraktik.group.kutamandarakanapp.register.data.ResultRegister
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    @FormUrlEncoded
    @POST("loginUser")
    fun login(@Field("email") email: String?,
              @Field("password") password: String?) : Call<ResultLogin>

    @FormUrlEncoded
    @POST("registerUser")
    fun register(@Field("username") username: String?,
                 @Field("email") email: String?,
                 @Field("password") password: String?) : Call<ResultRegister>

    @FormUrlEncoded
    @POST("addPenduduk")
    fun addPenduduk(@Field("nik") nik : String,
                    @Field("no_kk") no_kk : String,
                    @Field("nama") nama :  String,
                    @Field("tempat_lahir") tempat_lahir : String,
                    @Field("tgl_lahir") tgl_lahir : String,
                    @Field("jk") jk : String,
                    @Field("alamat") alamat: String,
                    @Field("agama") agama : String,
                    @Field("status") status : String,
                    @Field("pekerjaan") pekerjaan : String,
                    @Field("goldar") goldar : String) : Call<ResultStatus>

    //Fungsi get data
    @GET("getDataPenduduk")
    fun getData(): Call<ResultPenduduk>

    @GET("fetchPenduduk")
    fun fetchPenduduk(@Query("key") keyword: String?) : Call<ResultPenduduk>

    @GET("getDataLaki")
    fun getDataLaki(): Call<ResultPenduduk>

    @GET("getStatusLajang")
    fun getStatusLajang(): Call<ResultPenduduk>

    @GET("getStatusMenikah")
    fun getStatusMenikah(): Call<ResultPenduduk>

    @GET("getStatusCerai")
    fun getStatusCerai(): Call<ResultPenduduk>

    @GET("getStatusCeraiMati")
    fun getStatusCeraiMati(): Call<ResultPenduduk>

    @GET("getDataPerempuan")
    fun getDataPerempuan(): Call<ResultPenduduk>

    @GET("getGoldarA")
    fun getGoldarA(): Call<ResultPenduduk>

    @GET("getGoldarAB")
    fun getGoldarAB(): Call<ResultPenduduk>

    @GET("getGoldarB")
    fun getGoldarB(): Call<ResultPenduduk>

    @GET("getGoldarO")
    fun getGoldarO(): Call<ResultPenduduk>

    @GET("getKerjaWiraswasta")
    fun getKerjaWiraswasta(): Call<ResultPenduduk>

    @GET("getKerjaGuru")
    fun getKerjaGuru(): Call<ResultPenduduk>

    @GET("getKerjaPNS")
    fun getKerjaPNS(): Call<ResultPenduduk>

    @GET("getKerjaKaryawan")
    fun getKerjaKaryawan() : Call<ResultPenduduk>

    @GET("getKerjaTani")
    fun getKerjaTani(): Call<ResultPenduduk>


    @FormUrlEncoded
    @POST("deletePenduduk")
    fun deletePenduduk(@Field("nik") nik : String?) : Call<ResultStatus>

    @FormUrlEncoded
    @POST("updatePenduduk")
    fun updatePenduduk(@Field("nik") nik : String,
    @Field("no_kk") no_kk : String,
    @Field("nama") nama :  String,
    @Field("tempat_lahir") tempat_lahir : String,
    @Field("tgl_lahir") tgl_lahir : String,
    @Field("jk") jk : String,
    @Field("alamat") alamat: String,
    @Field("agama") agama : String,
    @Field("status") status : String,
    @Field("pekerjaan") pekerjaan : String,
    @Field("goldar") goldar : String) : Call<ResultStatus>


    @FormUrlEncoded
    @POST("addNote")
    fun addNote(@Field("judul") judul : String,
                @Field("deskripsi") deskripsi: String,
                @Field("tanggal") tanggal : String) : Call<ResultStatus>

    @GET("getNote")
    fun getNote() : Call<ResultNote>

    @FormUrlEncoded
    @POST("deleteNote")
    fun deleteNote(@Field("id") id : String?) : Call<ResultStatus>

    @FormUrlEncoded
    @POST("updateNote")
    fun updateNote(
                @Field("id") id : String,
                @Field("judul") judul : String,
                @Field("deskripsi") deskripsi: String,
                @Field("tanggal") tanggal: String) : Call<ResultStatus>

    @FormUrlEncoded
    @POST("addAparatur")
    fun addAparatur(@Field("nama") nama : String,
                    @Field("jabatan") jabatan: String,
                    @Field("pendidikan") pendidikan: String,
                    @Field("tmt") tmt: String,
                    @Field("jk") jk: String) : Call<ResultStatus>

    @GET("getAparatur")
    fun getAparatur() : Call<ResultAparatur>

    @FormUrlEncoded
    @POST("deleteAparatur")
    fun deleteAparatur(@Field("nipd") nipd: String?) : Call<ResultStatus>

    @FormUrlEncoded
    @POST("updateAparatur")
    fun updateAparatur(@Field("nipd") nipd: String,
                        @Field("nama") nama: String,
                        @Field("jabatan") jabatan: String,
                        @Field("pendidikan") pendidikan: String,
                        @Field("tmt") tmt: String,
                        @Field("jk") jk : String) : Call<ResultStatus>
}