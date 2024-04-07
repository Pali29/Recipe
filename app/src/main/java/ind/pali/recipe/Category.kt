package ind.pali.recipe

data class Category(val idcategory:String,
    val strcategory:String,
    val strcategorythumb:String,
    val strcategorydescription:String)

data class Categoriesresponse(val categories: List<Category>)
