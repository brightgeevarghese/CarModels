package edu.miu.carmodels.data

import edu.miu.carmodels.R
import edu.miu.carmodels.model.Car

class DataSource {
    fun loadCarModels(): List<Car> {
        return listOf(
            Car(R.drawable.mercedes_benz, R.string.mercedes_benz),
            Car(R.drawable.toyota_prius, R.string.toyota_prius),
            Car(R.drawable.chevrolet, R.string.chevrolet),
            Car(R.drawable.tesla, R.string.tesla)
        )
    }
}