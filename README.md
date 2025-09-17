Uppgift 3: Android Weather App Beskrivning:

Detta projekt är en Android-applikation som visar väderinformation för olika städer världen över. Appen är byggd helt i Kotlin och använder Open-Meteo API för att hämta temperatur och vindhastighet i realtid. Appen innehåller fyra fragment: Home, City List, Forecast och Settings, samt navigering via både backstack och BottomNavigationView.

Funktioner

Lista med städer från flera kontinenter.

Klicka på en stad för att visa aktuell temperatur och vindhastighet.

Backstack-navigation för enkel navigering fram och tillbaka mellan fragment.

Anpassad design för portrait och landscape.

API-integration med mervärde (inte enbart statiska strängar).

Fullt implementerad i Kotlin.

Installation

Klona detta repository:

git clone https://github.com/ditt-användarnamn/uppgift3.git

Öppna projektet i Android Studio.

Bygg projektet och installera APK på en Android-enhet eller emulator.

Struktur

MainActivity.kt – Huvudaktivitet med NavController och BottomNavigationView.

HomeFragment.kt – Startsida för appen.

CityListFragment.kt – Lista med städer, klick för att visa väder.

ForecastFragment.kt – Visar temperatur och vindhastighet för vald stad.

SettingsFragment.kt – Placeholder för inställningar.

network/RetrofitInstance.kt – Retrofit-konfiguration för API-anrop.

API

Open-Meteo API används för att hämta aktuellt väder.

Krav

Android Studio Arctic Fox eller senare

Kotlin 1.8+

Internetåtkomst
