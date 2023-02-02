package app.plantdiary.myplantdiary23SS002.dto

data class Plant(var genus : String, var species : String, var common : String = "") {
    override fun toString() = common
}

