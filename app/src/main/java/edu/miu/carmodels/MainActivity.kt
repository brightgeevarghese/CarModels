package edu.miu.carmodels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.miu.carmodels.data.DataSource
import edu.miu.carmodels.model.Car
import edu.miu.carmodels.ui.theme.CarModelsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarModelsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CarApp(modifier: Modifier = Modifier) {
    CarList(carList = DataSource().loadCarModels(), modifier = modifier)
}

@Composable
fun CarList(carList: List<Car>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Car Models",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        LazyRow(modifier = Modifier) {
            items(carList) {
                CarCard(
                    car = it,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }

}

@Composable
fun CarCard(car: Car, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = car.imageResourceId),
                contentDescription = stringResource(id = car.stringResourceId),
                modifier = modifier
                    .height(194.dp)
                    .width(352.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = car.stringResourceId),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CarsAppPreview() {
    CarModelsTheme {
        CarApp()
    }
}