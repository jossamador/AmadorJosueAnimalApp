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
                image = "https://images.pexels.com/photos/23540962/pexels-photo-23540962.jpeg",
                gallery = listOf(
                    "https://images.pexels.com/photos/236601/pexels-photo-236601.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/145939/pexels-photo-145939.jpeg",
                    "https://images.pexels.com/photos/572861/pexels-photo-572861.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/814898/pexels-photo-814898.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/2689436/pexels-photo-2689436.jpeg?auto=compress&cs=tinysrgb&w=1200"
                ),
                facts = listOf("Puede pesar hasta 300 kg.", "Gran nadador."),
                environment = "selva"
            ),
            Animal(
                id = "2",
                name = "Camello",
                description = "Adaptado al clima seco del desierto.",
                image = "https://images.pexels.com/photos/133395/pexels-photo-133395.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                gallery = listOf(
                    "https://images.pexels.com/photos/998639/pexels-photo-998639.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/1915950/pexels-photo-1915950.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/815880/pexels-photo-815880.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/2080187/pexels-photo-2080187.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/30710171/pexels-photo-30710171/free-photo-of-sahara.jpeg?auto=compress&cs=tinysrgb&w=1200"
                ),
                facts = listOf("Puede pasar días sin agua.", "Tiene jorobas."),
                environment = "desierto"
            ),
            Animal(
                id = "3",
                name = "Delfín",
                description = "Mamífero marino inteligente y social.",
                image = "https://images.pexels.com/photos/1986374/pexels-photo-1986374.jpeg?auto=compress&cs=tinysrgb&w=800",
                gallery = listOf(
                    "https://images.pexels.com/photos/9406883/pexels-photo-9406883.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/64219/dolphin-marine-mammals-water-sea-64219.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/4886378/pexels-photo-4886378.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/162079/dolphin-sea-marine-mammals-wise-162079.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/3354346/pexels-photo-3354346.jpeg?auto=compress&cs=tinysrgb&w=1200"
                ),
                facts = listOf("Usa ecolocalización.", "Nada en grupos."),
                environment = "oceano"
            ),
            Animal(
                id = "4",
                name = "Águila real",
                description = "Ave rapaz de gran tamaño.",
                image = "https://images.pexels.com/photos/18865652/pexels-photo-18865652/free-photo-of-aguila-calva-junto-al-tronco-de-un-arbol.jpeg?auto=compress&cs=tinysrgb&w=800",
                gallery = listOf(
                    "https://images.pexels.com/photos/1905590/pexels-photo-1905590.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/16868735/pexels-photo-16868735/free-photo-of-naturaleza-aguila-retrato-fotografia-de-animales.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/18145372/pexels-photo-18145372/free-photo-of-blanco-y-negro-naturaleza-pajaro-aguila.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/7002398/pexels-photo-7002398.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/12776314/pexels-photo-12776314.jpeg?auto=compress&cs=tinysrgb&w=1200"
                ),
                facts = listOf("Gran vista.", "Caza desde el aire."),
                environment = "montana"
            ),
            Animal(
                id = "5",
                name = "Pingüino emperador",
                description = "Ave marina que no vuela, adaptada al frío.",
                image = "https://images.pexels.com/photos/20439546/pexels-photo-20439546.jpeg",
                gallery = listOf(
                    "https://images.pexels.com/photos/641283/pexels-photo-641283.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/31293895/pexels-photo-31293895/free-photo-of-majestuoso-pinguino-emperador-en-un-paisaje-nevado.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/4169865/pexels-photo-4169865.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/26800250/pexels-photo-26800250/free-photo-of-resfriado-frio-iceberg-mar.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/31934796/pexels-photo-31934796/free-photo-of-pinguinos-de-humboldt-en-el-zoologico-del-callao-peru.jpeg?auto=compress&cs=tinysrgb&w=1200"
                ),
                facts = listOf("Puede nadar grandes distancias.", "Vive en colonias."),
                environment = "polo"
            ),
            Animal(
                id = "6",
                name = "Zorro ártico",
                description = "Mamífero adaptado al clima polar.",
                image = "https://images.pexels.com/photos/27067817/pexels-photo-27067817/free-photo-of-mullido-fotografia-de-animales-fotografia-de-vida-salvaje-suave.jpeg?auto=compress&cs=tinysrgb&w=800",
                gallery = listOf(
                    "https://images.pexels.com/photos/11251669/pexels-photo-11251669.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/26690472/pexels-photo-26690472/free-photo-of-carretera-naturaleza-rural-fotografia-de-animales.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/27067815/pexels-photo-27067815/free-photo-of-nieve-nevar-invierno-jugando.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/26690635/pexels-photo-26690635/free-photo-of-zorro-artico-peludo-tumbado-en-la-nieve.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/26690042/pexels-photo-26690042/free-photo-of-naturaleza-hierba-cesped-prado.jpeg?auto=compress&cs=tinysrgb&w=800"

                ),
                facts = listOf("Su pelaje cambia según la estación.", "Gran cazador de roedores."),
                environment = "tundra"
            ),
            Animal(
                id = "7",
                name = "Cocodrilo del Nilo",
                description = "Reptil semiacuático muy antiguo.",
                image = "https://images.pexels.com/photos/20736535/pexels-photo-20736535.jpeg",
                gallery = listOf(
                    "https://images.pexels.com/photos/31963715/pexels-photo-31963715/free-photo-of-vista-aerea-de-cocodrilos-en-la-orilla-del-rio-en-zambia.jpeg?auto=compress&cs=tinysrgb&w=800",
                    "https://images.pexels.com/photos/26707333/pexels-photo-26707333/free-photo-of-bosque-animal-rio-reptil.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/2576761/pexels-photo-2576761.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/16187160/pexels-photo-16187160/free-photo-of-naturaleza-animal-reptil-ojo.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/27721396/pexels-photo-27721396/free-photo-of-naturaleza-agua-animal-parque.jpeg?auto=compress&cs=tinysrgb&w=1200"
                ),
                facts = listOf("Puede medir más de 5 metros.", "Caza al acecho."),
                environment = "pantano"
            ),
            Animal(
                id = "8",
                name = "Panda gigante",
                description = "Mamífero herbívoro conocido por su dieta de bambú.",
                image = "https://images.pexels.com/photos/29480533/pexels-photo-29480533.jpeg",
                gallery = listOf(
                    "https://images.pexels.com/photos/30366935/pexels-photo-30366935.jpeg",
                    "https://images.pexels.com/photos/29088370/pexels-photo-29088370.jpeg",
                    "https://images.pexels.com/photos/11909034/pexels-photo-11909034.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/1123765/pexels-photo-1123765.jpeg?auto=compress&cs=tinysrgb&w=1200",
                    "https://images.pexels.com/photos/17723101/pexels-photo-17723101/free-photo-of-naturaleza-verano-bosque-animal.jpeg?auto=compress&cs=tinysrgb&w=1200"
                ),
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
                image = "https://images.pexels.com/photos/1928279/pexels-photo-1928279.jpeg?auto=compress&cs=tinysrgb&w=800",
                facts = listOf("Son ecosistemas húmedos con aguas estancadas", "Tiene lluvias frecuentes durante todo el año", "Presenta una gran variedad de árboles de gran altura")
            ),
            Ambiente(
                id = "desierto",
                name = "Desierto",
                description = "Región árida con temperaturas extremas.",
                image = "https://images.pexels.com/photos/30478414/pexels-photo-30478414.jpeg?auto=compress&cs=tinysrgb&w=800",
                facts = listOf("Las temperaturas pueden superar los 50°C durante el día", "Tiene una vegetación escasa y especializada", "La fauna está adaptada a sobrevivir con muy poca agua")
            ),
            Ambiente(
                id = "oceano",
                name = "Océano",
                description = "Inmensa masa de agua salada que cubre el 70% del planeta.",
                image = "https://images.pexels.com/photos/31980247/pexels-photo-31980247/free-photo-of-impresionante-puesta-de-sol-sobre-el-horizonte-oceanico-de-melbourne.jpeg?auto=compress&cs=tinysrgb&w=800",
                facts = listOf("Ocupa aproximadamente el 70% de la superficie terrestre","Alberga una biodiversidad inmensa en diferentes profundidades","Regula el clima global mediante corrientes oceánicas")
            ),
            Ambiente(
                id = "montana",
                name = "Montaña",
                description = "Zona elevada con clima frío y aire delgado.",
                image = "https://images.pexels.com/photos/1624496/pexels-photo-1624496.jpeg?auto=compress&cs=tinysrgb&w=800",
                facts = listOf("El clima es más frío conforme aumenta la altitud","Son fuentes de agua dulce por la presencia de glaciares","La vida animal está adaptada a terrenos rocosos y aire delgado")
            ),
            Ambiente(
                id = "polo",
                name = "Polo",
                description = "Ambiente helado, hogar de especies adaptadas al frío extremo.",
                image = "https://images.pexels.com/photos/16144193/pexels-photo-16144193/free-photo-of-resfriado-frio-glaciar-nieve.jpeg?auto=compress&cs=tinysrgb&w=800",
                facts = listOf("Las temperaturas pueden llegar a -60°C en invierno","La luz solar puede desaparecer por meses durante el año","Es hogar de especies como pingüinos y osos polares")
            ),
            Ambiente(
                id = "tundra",
                name = "Tundra",
                description = "Bioma frío con vegetación baja y suelos helados.",
                image = "https://images.pexels.com/photos/2563282/pexels-photo-2563282.jpeg?auto=compress&cs=tinysrgb&w=800",
                facts = listOf("El suelo está congelado la mayor parte del año (permafrost)","Hay una corta temporada de crecimiento en verano","La vegetación es baja: musgos, líquenes y arbustos")
            ),
            Ambiente(
                id = "pantano",
                name = "Pantano",
                description = "Zona húmeda con aguas estancadas y vegetación densa.",
                image = "https://images.pexels.com/photos/31996011/pexels-photo-31996011.jpeg?auto=compress&cs=tinysrgb&w=800",
                facts = listOf("Son ecosistemas húmedos con aguas estancadas","Albergan gran cantidad de insectos, aves y reptiles","Son zonas naturales de filtración de agua")
            ),
            Ambiente(
                id = "bosque",
                name = "Bosque",
                description = "Región densa con árboles, hogar de muchas especies.",
                image = "https://images.pexels.com/photos/338936/pexels-photo-338936.jpeg?auto=compress&cs=tinysrgb&w=800",
                facts = listOf("Regulan el oxígeno y el dióxido de carbono en la atmósfera","Son hábitats críticos para mamíferos, aves e insectos","Presentan estaciones bien marcadas en bosques templados")
            )
        )
    }
}