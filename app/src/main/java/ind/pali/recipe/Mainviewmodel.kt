package ind.pali.recipe

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class Mainviewmodel: ViewModel() {

    private val categoriestate = mutableStateOf(Recipestate())
    val categoriesstate: State<Recipestate> = categoriestate

    init {
        fetchcategories()
    }

    private fun fetchcategories()
    {
        viewModelScope.launch {
            try {
                val response = recipeservice.getcategories()
                categoriestate.value = categoriestate.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            } catch (e: Exception){
                categoriestate.value = categoriestate.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.message}"
                )
            }
        }
    }

    data class Recipestate(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}