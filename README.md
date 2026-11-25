# PadelMatch — Activitat 06 (Menú i Llistes Dinàmiques)

Aplicació Android feta amb Kotlin i XML per buscar, apuntar-se i gestionar partits de pàdel.

> **Avís de millora / Recuperació 488-RA4:** Hem canviat el sistema de navegació de l'app. En lloc dels botons simples que teníem al principi, ara fem servir un menú de navegació estàndard d'Android amb un fitxer de recursos XML (`menu_navegacio.xml`) i un `BottomNavigationView` perquè funcioni bé i sigui més còmode moure's entre pantalles.

---

## 1. Què hem fet a l'aplicació

* **Pantalla d'inici (`splashscreen.kt` - 489-RA3):** Quan obres l'app surt el nostre logotip (`@drawable/logo`) amb una animació (`res/anim/splash_animation.xml`) que dura un parell de segons abans d'entrar al login.
* **Menú de navegació (`488-RA4`):** Hem creat el fitxer `res/menu/menu_navegacio.xml` i l'hem connectat a un `BottomNavigationView`. Des d'aquí l'usuari pot anar directe a **Partits** (`pantalla_partits`), **Els meus partits** (`mispartidos`) o **Configuració** (`activity_settings`).
* **Llistes dinàmiques (`488-RA3`):** Hem muntat dos `RecyclerView` diferents, cadascun amb el seu propi `Adapter` i `ViewHolder`:
  * **Llista general de partits (`PartitAdapter.kt`):** Ensenya tots els partits disponibles amb la pista, l'hora, el nivell i l'estat per poder-s'hi apuntar.
  * **Els meus partits (`MisPartidosAdapter.kt`):** Té un disseny propi per als partits on ja estem apuntats i permet **afegir**, **modificar** i **eliminar** partits. Cada vegada que fem una d'aquestes accions, surt un `Toast` per pantalla i es guarda un missatge al `Logcat`.

---

## 2. Com està fet el codi

### El menú de navegació (`menu_navegacio.xml` i `pantalla_partits.kt`)
Primer vam definir les tres opcions del menú dins de `res/menu/menu_navegacio.xml`, posant a cada una el seu `id`, una icona i el text. Després, a les pantalles principals, enllacem el `BottomNavigationView` amb `findViewById` i fem servir `setOnItemSelectedListener`. Dins d'aquest listener, amb un `when (item.itemId)` mirem quina opció ha premut l'usuari i obrim l'Activity que toca amb un `Intent`. També marquem amb `selectedItemId` en quina pestanya estem en cada moment.

### Les llistes (`Adapter` i `ViewHolder`)
Per mostrar els partits sense carregar el mòbil, utilitzem `RecyclerView` amb un `LinearLayoutManager`:
* **`ViewHolder` (`PartitViewHolder` i `MisPartidosViewHolder`):** És la classe que guarda els components de cada targeta (els `TextView` amb el nom, la pista, l'hora, el nivell i els botons). Així Android no ha d'anar fent `findViewById` tota l'estona mentre fas scroll.
* **`Adapter` (`PartitAdapter` i `MisPartidosAdapter`):** S'encarrega d'agafar el disseny XML de cada fila (`item_partit.xml` i `item_mispartidos.xml`) a `onCreateViewHolder` i d'omplir-lo amb les dades de cada partit a `onBindViewHolder`.
* **Afegir, modificar i eliminar:** A `MisPartidosAdapter` i `mispartidos.kt` hem programat els clics dels botons de cada targeta i del botó flotant (`+`). Quan afegim un partit avisem l'adapter amb `notifyItemInserted()`, quan l'editem fem servir `notifyItemChanged()`, i quan l'esborrem cridem `notifyItemRemoved()`. A més, en tots tres casos mostrem un `Toast` perquè l'usuari vegi que s'ha fet el canvi i deixem un `Log.d()` per comprovar-ho al debug.

---

## 3. Usabilitat i Accessibilitat per pantalla (`1708-RA3`)

Hem repassat totes les pantalles perquè l'app s'entengui bé a primera vista i es pugui fer servir amb lectors de pantalla (*TalkBack*):

* **`splashscreen`:** Hem posat `android:contentDescription` al logotip perquè un lector de pantalla sàpiga què és, i l'animació és curta perquè no molesti ni retardi l'entrada a l'app.
* **`login` i `RegisterActivity`:** Tots els quadres de text tenen un `hint` clar perquè se sàpiga què cal escriure i fan servir fons fosc (`@color/backBlack`) amb lletres blanques perquè es llegeixin bé.
* **`pantalla_partits`:**
  * Les icones que fan de botó (el micròfon `btnMic`, el filtre `img_filtro` i el botó `+` per crear partit `fab_add_match`) tenen el seu `android:contentDescription` tret de `strings.xml`.
  * Els botons de dalt tenen una mida mínima de `48dp` x `48dp` perquè sigui fàcil clicar-los amb el dit sense fallar.
  * Al menú de navegació es veu tant la icona com el text a sota (`app:labelVisibilityMode="labeled"`) perquè quedi clar on porta cada botó.
* **`mispartidos`:** Els botons d'editar i esborrar de cada partit tenen descripció per a lectors de pantalla, bona separació entre ells i confirmen l'acció amb un `Toast`.
* **`activity_crearpartit`, `filtro`, `activity_settings` i `ayuda`:** Segueixen els mateixos colors amb bon contrast, tenen tots els textos a `strings.xml` i no tenen botons enganxats o tapats.

---

## 4. Lliurament

* **Repositori GitHub:** [PadelMatch_Interficies](https://github.com/EricMacarroCanton/PadelMatch_Interficies)
* **Vídeo demostratiu:** *(Enganxa aquí l'enllaç de YouTube ensenyant l'animació inicial, el menú i com s'afegeixen, modifiquen i eliminen partits)*