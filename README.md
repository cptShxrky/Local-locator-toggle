# Locator Toggle (Fabric, Minecraft 1.21.11)

Clientseitige Fabric-Mod: schaltet die Locator Bar per Hotkey (Standard: **K**, änderbar unter
Steuerung → Sonstiges) an und aus. Ist sie aus, zeigt das Spiel wieder die normale XP-Leiste.
Funktioniert auch zusammen mit Local Locator.

Basiert auf der offiziellen Fabric-Beispielvorlage (Branch 1.21.11), alle Versionen sind passend gesetzt.

## .jar ohne lokale Installation bauen (GitHub)

1. Neues GitHub-Repository anlegen und den gesamten Inhalt dieses Ordners hochladen/pushen
   (inklusive des versteckten Ordners `.github`).
2. Im Repo auf **Actions** gehen, den Lauf **build** öffnen.
3. Unten unter **Artifacts** den Eintrag **Artifacts** herunterladen. Darin liegt die Mod als
   `locatortoggle-1.0.0.jar` (die Datei **ohne** `-sources` im Namen).
4. Die `.jar` in `.minecraft/mods` legen. Außerdem wird die **Fabric API** benötigt.

## .jar lokal bauen

Mit installiertem JDK 21 oder neuer im Projektordner:

    ./gradlew build        (Windows: gradlew.bat build)

Die Datei liegt danach in `build/libs/`.

## Hinweis

Die Mixin-Methode `Gui#nextContextualInfoState` stammt aus den Mojang-Mappings von 1.21.11.
Schlägt der Build mit einem Mixin-Fehler fehl, bitte die Fehlermeldung weitergeben.
