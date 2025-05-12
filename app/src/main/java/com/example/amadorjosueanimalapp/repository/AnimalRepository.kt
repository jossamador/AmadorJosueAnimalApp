package com.example.amadorjosueanimalapp.repository

import com.example.amadorjosueanimalapp.model.Animal
import com.example.amadorjosueanimalapp.model.Ambiente
import kotlinx.coroutines.delay

object AnimalRepository {

    suspend fun getAnimals(): List<Animal> {
        delay(1000)
        return listOf(
            Animal(
                id = "1",
                name = "Tigre",
                description = "El tigre es el felino más grande del mundo.",
                image = "https://upload.wikimedia.org/wikipedia/commons/5/56/Tiger.50.jpg",
                gallery = listOf(
                    "https://upload.wikimedia.org/wikipedia/commons/e/e8/Tiger_in_Ranthambhore.jpg"
                ),
                facts = listOf("Puede pesar hasta 300 kg.", "Gran nadador."),
                environment = "selva"
            ),
            Animal(
                id = "2",
                name = "Camello",
                description = "Adaptado al clima seco del desierto.",
                image = "https://upload.wikimedia.org/wikipedia/commons/7/7a/Camel_01.jpg",
                gallery = listOf(),
                facts = listOf("Puede pasar días sin agua.", "Tiene jorobas."),
                environment = "desierto"
            ),
            Animal(
                id = "3",
                name = "Delfín",
                description = "Mamífero marino inteligente y social.",
                image = "https://upload.wikimedia.org/wikipedia/commons/e/e7/Common_dolphin_noaa.jpg",
                gallery = listOf(),
                facts = listOf("Usa ecolocalización.", "Nada en grupos."),
                environment = "oceano"
            ),
            Animal(
                id = "4",
                name = "Águila real",
                description = "Ave rapaz de gran tamaño.",
                image = "https://upload.wikimedia.org/wikipedia/commons/4/4e/Aquila_chrysaetos.jpg",
                gallery = listOf(),
                facts = listOf("Gran vista.", "Caza desde el aire."),
                environment = "montana"
            ),
            Animal(
                id = "5",
                name = "Pingüino emperador",
                description = "Ave marina que no vuela, adaptada al frío.",
                image = "https://upload.wikimedia.org/wikipedia/commons/9/95/Emperor_Penguin_with_chick.jpg",
                gallery = listOf(),
                facts = listOf("Puede nadar grandes distancias.", "Vive en colonias."),
                environment = "polo"
            ),
            Animal(
                id = "6",
                name = "Zorro ártico",
                description = "Mamífero adaptado al clima polar.",
                image = "https://upload.wikimedia.org/wikipedia/commons/1/1b/Alopex_lagopus.jpg",
                gallery = listOf(),
                facts = listOf("Su pelaje cambia según la estación.", "Gran cazador de roedores."),
                environment = "tundra"
            ),
            Animal(
                id = "7",
                name = "Cocodrilo del Nilo",
                description = "Reptil semiacuático muy antiguo.",
                image = "https://upload.wikimedia.org/wikipedia/commons/4/4f/NileCrocodile.jpg",
                gallery = listOf(),
                facts = listOf("Puede medir más de 5 metros.", "Caza al acecho."),
                environment = "pantano"
            ),
            Animal(
                id = "8",
                name = "Panda gigante",
                description = "Mamífero herbívoro conocido por su dieta de bambú.",
                image = "https://upload.wikimedia.org/wikipedia/commons/0/0f/Grosser_Panda.JPG",
                gallery = listOf(),
                facts = listOf("Habita bosques de bambú en China.", "Está en peligro de extinción."),
                environment = "bosque"
            )
        )
    }

    suspend fun getAmbientes(): List<Ambiente> {
        delay(1000)
        return listOf(
            Ambiente(
                id = "selva",
                name = "Selva",
                description = "Ambiente tropical con gran biodiversidad.",
                image = "https://upload.wikimedia.org/wikipedia/commons/e/e3/Amazon_Rainforest.jpg"
            ),
            Ambiente(
                id = "desierto",
                name = "Desierto",
                description = "Región árida con temperaturas extremas.",
                image = "https://upload.wikimedia.org/wikipedia/commons/6/6b/Sahara_Desert_%282310864845%29.jpg"
            ),
            Ambiente(
                id = "oceano",
                name = "Océano",
                description = "Inmensa masa de agua salada que cubre el 70% del planeta.",
                image = "https://upload.wikimedia.org/wikipedia/commons/4/4e/Pacific_Ocean_%2824873064327%29.jpg"
            ),
            Ambiente(
                id = "montana",
                name = "Montaña",
                description = "Zona elevada con clima frío y aire delgado.",
                image = "https://upload.wikimedia.org/wikipedia/commons/f/f6/Himalayas.jpg"
            ),
            Ambiente(
                id = "polo",
                name = "Polo",
                description = "Ambiente helado, hogar de especies adaptadas al frío extremo.",
                image = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Antarctica.jpg"
            ),
            Ambiente(
                id = "tundra",
                name = "Tundra",
                description = "Bioma frío con vegetación baja y suelos helados.",
                image = "https://upload.wikimedia.org/wikipedia/commons/3/3e/Tundra_in_Siberia.jpg"
            ),
            Ambiente(
                id = "pantano",
                name = "Pantano",
                description = "Zona húmeda con aguas estancadas y vegetación densa.",
                image = "https://upload.wikimedia.org/wikipedia/commons/f/fb/Everglades.jpg"
            ),
            Ambiente(
                id = "bosque",
                name = "Bosque",
                description = "Región densa con árboles, hogar de muchas especies.",
                image = "https://upload.wikimedia.org/wikipedia/commons/a/a5/Black_Forest_-_Germany.jpg"
            )
        )
    }
}