# AITest Android App

Deze repository bevat een volledig Android-project dat klaar is om te openen in Android Studio.
Het project gebruikt Kotlin, AndroidX en Material Design componenten en toont een welkomstbericht in de hoofdactiviteit.

## Structuur
- `app/`: Bevat de Android-app module met broncode, resources en configuratie.
- `build.gradle.kts` en `settings.gradle.kts`: Projectconfiguratie voor Gradle.
- `gradle.properties`: Globale Gradle-instellingen.

## Aan de slag
1. **Project importeren**
   - Open de map in Android Studio (Giraffe of nieuwer aanbevolen).
   - Zodra het project is geladen, start Android Studio automatisch een Gradle-sync. Wacht tot deze voltooid is (linksonder verschijnt "Gradle sync finished").
2. **Run configuration kiezen**
   - In de toolbar bovenaan zou nu een run configuration **app** zichtbaar zijn. Deze is voor je voorgeconfigureerd en start de launcher-activiteit `com.example.aitest.MainActivity`.
   - Zie je alleen "Add Configuration" staan? Klik dan daarop, kies **+ > Android App**, selecteer als module `app` en bevestig.
3. **App starten**
   - Kies een emulator of verbonden apparaat (Android 7.0 of hoger) in dezelfde toolbar.
   - Klik op **Run** (▶) om de applicatie te bouwen en te starten.

## Handmatig bouwen via Gradle
Als je liever vanuit de terminal werkt, zorg dan dat de Android SDK geconfigureerd is en voer vervolgens uit:
```bash
gradle :app:assembleDebug
```
Het gegenereerde APK-bestand vind je daarna in `app/build/outputs/apk/debug/`.

## Functies
- Modern Material Design-thema met ondersteuning voor donker thema.
- `MainActivity` is de launcher-activiteit en vormt het startpunt van de app.
- Welkomstbericht dat je eenvoudig kunt aanpassen in `app/src/main/res/values/strings.xml`.

Veel plezier met het uitbreiden van de app!
