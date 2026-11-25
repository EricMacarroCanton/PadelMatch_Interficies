## Arquitectura MVVM i Validacions (ACT07.1)

En aquesta part del projecte hem recodificat les pantalles d'inici de sessió (`OnlyloginActivity`) i registre (`RegisterActivity`) per aplicar el patró MVVM (Model-View-ViewModel) i separar la lògica de la interfície.

Per fer-ho hem creat dues classes dins de la carpeta `ViewModels`:

* `LoginViewModel`: S'encarrega de validar que el correu no estigui buit, que tingui un format correcte i que la contrasenya tingui almenys 6 caràcters.
* `RegisterViewModel`: Comprova que el nom d'usuari tingui mínim 3 caràcters sense símbols estranys, que el correu sigui vàlid, que la contrasenya tingui com a mínim 6 caràcters (incloent-hi una majúscula i un número) i que el nivell de pàdel introduït estigui entre 1 i 7.

Dins dels dos ViewModels fem servir `MutableLiveData` privats per guardar l'estat dels errors de cada camp i el resultat de la validació, i els exposem com a `LiveData` públics. D'aquesta manera, les Activities només s'encarreguen de mostrar la vista i escoltar els canvis amb `.observe()` per pintar els missatges d'error als `TextInputLayout` o canviar de pantalla quan tot és correcte, mantenint les dades encara que es giri la pantalla del mòbil.

Pel que fa a l'accessibilitat, en aquesta activitat no hi ha cap apartat específic d'accessibilitat a tenir en compte.