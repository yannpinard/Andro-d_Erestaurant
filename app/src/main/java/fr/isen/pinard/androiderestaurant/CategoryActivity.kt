package fr.isen.pinard.androiderestaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.pinard.androiderestaurant.ui.theme.AndroidERestaurantTheme

sealed class Category(val name: String, val dishes: List<Plat>)

data class Plat(val name: String, val description: String)

object Entrees : Category("Entrées", listOf(
    Plat("PETITE SALADE VERTE", "salade italienne & crudités de saison"),
    Plat("MINI SALUMI", "planchette de charcuterie de votre choix"),
    Plat("TARTARE DE POLIPO", "tartare de poulpe frais à la sicilienne 50g"),
    Plat("BURRATINA PESTO", "burratina 50g, Pesto Genovese, émietté de Gressins"),
))

object PlatsPrincipaux : Category("Plats Principaux", listOf(
    Plat("SPAGHETTI PIEMONTESE", "pâtes fraiches, pesto, jambon cuit, mozzarella"),
    Plat("TAGLIATELLE PANCETTA", "pâtes fraiches, gorgonzola, pancetta"),
    Plat("TAGLIATELLE CARBONARA", "pâtes fraiches, pecorino, œuf, pancetta"),
    Plat("LASAGNE A L’EMILIANA", "lasagne au four, sauce tomate, viande de boeuf, parmesan"),
))

object Desserts : Category("Desserts", listOf(
    Plat("SALADE DE FRUITS", "fruits de saison, chantilly maison"),
    Plat("PINSA NOCCIOLATTA", "1/2 pinsa, Nocciolatta, chantilly maison"),
    // Ajoutez d'autres desserts ici
))

class CategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = intent.getSerializableExtra("category") as? Category ?: Entrees
        setContent {
            AndroidERestaurantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(android.graphics.Color.parseColor("#032757"))
                ) {
                    CategoryComponent(category, ::goToDetail)
                }
            }
        }
    }
    companion object {
        const val CATEGORY_KEY = "category"
    }

    private fun goToDetail(dish: Plat) {
        // Implémentez la logique pour afficher les détails du plat ici
    }
}

@Composable
fun CategoryComponent(category: Category, onDishClicked: (Plat) -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(color = Color(android.graphics.Color.parseColor("#032757")))
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = category.name,
            fontSize = 24.sp,
            color = Color(android.graphics.Color.parseColor("#032757")),
            modifier = Modifier.padding(8.dp)
        )
        DishListComponent(dishes = category.dishes, onDishClicked = onDishClicked)
    }
}

@Composable
fun DishListComponent(dishes: List<Plat>, onDishClicked: (Plat) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(dishes) { dish ->
            DishRow(dish, onDishClicked)
        }
    }
}

@Composable
fun DishRow(dish: Plat, onDishClicked: (Plat) -> Unit) {
    Card (
        modifier = Modifier.clickable { onDishClicked(dish) }
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = dish.name, fontSize = 18.sp)
            Text(text = dish.description, fontSize = 14.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MenuContentPreview() {
    AndroidERestaurantTheme {
        val entrees = listOf("entree1", "entree2", "entree3", "entree4")
        val plats = listOf("plat1", "plat2", "plat3", "plat4")
        val desserts = listOf("dessert1", "dessert2", "dessert3", "dessert4")
    }
}