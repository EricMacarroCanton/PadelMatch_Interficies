# 🎾 PadelMatch

Projecte d'aplicació mòbil per a Android fet en **Kotlin**. L'objectiu de l'app és que els jugadors de pàdel puguin buscar partits disponibles, apuntar-s'hi o crear-ne de nous segons el seu nivell i posició a la pista.

---

## 📱 Què fa l'aplicació?

* **Login i Registre (`OnlyloginActivity`, `RegisterActivity`):** Pantalles inicials perquè l'usuari pugui iniciar sessió o crear un compte nou.
* **Llista de Partits (`pantalla_partits`):** Pantalla principal on es mostren els partits disponibles amb el nom del club, el nivell, l'hora, les places lliures i la posició que es busca (Drive, Revés o Qualsevol).
* **Els Meus Partits (`mispartidos`):** Apartat on l'usuari pot veure els partits on està apuntat (confirmats, pendents o ja jugats) i pot editar-los o cancel·lar la seva plaça.
* **Crear i Editar Partit (`activity_crearpartit`):** Formulari que s'obre des del botó flotant `+` per afegir un partit nou escollint el club, data, hora, nivell (amb un Slider), posició i preu.
* **Filtres (`filtro`):** Pantalla per filtrar els partits segons les preferències de cerca.
* **Configuració i Ajuda (`activity_settings`, `ayuda`):** Opcions de configuració de l'usuari, pantalla d'ajuda i botó per tancar sessió.

---

## 🛠️ Com està fet

* **Llenguatge:** Kotlin.
* **Disseny de pantalles:** Fitxers XML utilitzant components de **Material Design** (`MaterialCardView`, `MaterialButton`, `TextInputLayout`, `FloatingActionButton`, `Slider`).
* **Layouts:** Principalment `ConstraintLayout`, `LinearLayout` i `ScrollView` per adaptar-se bé a la pantalla.
* **Llistes dinàmiques:** Hem implementat un `RecyclerView` amb el seu propi `Adapter` (`PartitsAdapter`) i `ViewHolder` per carregar dades de prova i gestionar els botons d'afegir, modificar i eliminar partits (mostrant avisos amb `Toast` i missatges al `Logcat`).
* **Estil visual:** Disseny en **mode fosc** combinant fons negre (`backBlack`), targetes en gris fosc (`secondGrey`) i detalls en verd (`green`).

---

## 📂 Estructura dels fitxers principals

```text
app/src/main/
├── java/com/example/padelmatch_interficies/
│   ├── OnlyloginActivity.kt       # Inici de sessió
│   ├── RegisterActivity.kt        # Registre d'usuari
│   ├── pantalla_partits.kt        # Llistat principal de partits
│   ├── mispartidos.kt             # Partits de l'usuari
│   ├── activity_crearpartit.kt    # Formulari per crear/editar partit
│   ├── filtro.kt                  # Filtres de cerca
│   ├── activity_settings.kt       # Configuració i tancar sessió
│   ├── ayuda.kt                   # Pantalla d'ajuda
│   ├── Partit.kt                  # Classe model (data class)
│   └── PartitsAdapter.kt          # Adapter i ViewHolder del RecyclerView
└── res/
    ├── layout/                    # Tots els XML de les pantalles i dels ítems (item_partit, item_meu_partit)
    └── values/                    # Colors, textos (strings.xml) i tema de l'app (themes.xml)