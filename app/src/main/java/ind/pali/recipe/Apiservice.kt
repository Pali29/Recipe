package ind.pali.recipe

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl("www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

        val recipeservice = retrofit.create(Apiservice::class.java)
interface Apiservice{
    @GET("categories.php")
    suspend fun getcategories():Categoriesresponse
}