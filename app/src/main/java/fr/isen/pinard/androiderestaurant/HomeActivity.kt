package fr.isen.pinard.androiderestaurant

import android.content.Intent
import android.widget.Toast
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.isen.pinard.androiderestaurant.ui.theme.AndroidERestaurantTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(android.graphics.Color.parseColor("#032757"))
                ) {
                    Greeting(::onMenuClicked)
                }
            }
        }
    }


    private fun onMenuClicked(category: String) {
        Toast.makeText(this, category, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, CategoryActivity::class.java).apply {
            putExtra(CategoryActivity.CATEGORY_KEY, category)
        }
        startActivity(intent)

    }
}

@Composable
fun Greeting(onMenuClicked: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#032757")))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(R.drawable.droidrestaurant),
                contentDescription = "Contact profile picture",
                modifier = Modifier.size(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Ajout d'un espace vertical

        Text(
            text = "Bienvenue chez \nDroïdERestaurant",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp)) // Ajout d'un espace vertical

        // Nouvelle colonne avec les boutons "Entrée", "Plat" et "Dessert"
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(color = Color(android.graphics.Color.parseColor("#032757")))
                .fillMaxWidth()
        ) {

            OutlinedButton(
                onClick = { onMenuClicked("Entrée") },
                modifier = Modifier
                    //.border(1.dp, Color.White) // Contour blanc des boutons
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Entrée", color = Color.White, fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(8.dp)) // Ajout d'un espace vertical

            OutlinedButton(
                onClick = { onMenuClicked("Plat") },
                modifier = Modifier
                    //.border(1.dp, Color.White) // Contour blanc des boutons
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Plat", color = Color.White, fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(8.dp)) // Ajout d'un espace vertical

            OutlinedButton(
                onClick = { onMenuClicked("Dessert") },
                modifier = Modifier
                    //.border(1.dp, Color.White) // Contour blanc des boutons
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Dessert", color = Color.White, fontSize = 20.sp)
            }
        }
    }
}





