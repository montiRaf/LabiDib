# DibDib - Un Gioco di Ruolo Ambientato al DIB

DibDib è un semplice gioco di ruolo testuale sviluppato in Java, ambientato nel Dipartimento di Informatica (DIB). L'obiettivo del gioco è esplorare i locali dell'università, interagire con personaggi e oggetti, e raggiungere la biblioteca per studiare.

## Descrizione

Nel mondo di DibDib, troverai personaggi amici e ostili, oltre a diversi attrezzi che potrai raccogliere, usare, o regalare. Il gioco si basa su comandi testuali che permettono di interagire con l'ambiente circostante. Per iniziare, riceverai un messaggio di benvenuto con un'introduzione alla trama. 

Utilizza il comando `aiuto` per conoscere le istruzioni e i comandi disponibili.

### Funzionalità Principali

- Esplora diverse stanze all'interno del DIB.
- Interagisci con personaggi e oggetti.
- Completa l'obiettivo di raggiungere la biblioteca prima di esaurire i CFU (Crediti Formativi Universitari).
- Gioco basato su comandi testuali con un'interfaccia console.

## Struttura del Progetto

Il progetto è organizzato in diversi package per migliorare la modularità del codice:

- **`it.dib.diadia`**: Contiene la classe principale `DibDib` e gestisce l'interazione con il giocatore.
- **`it.dib.diadia.ambienti`**: Definisce le stanze e la logica dell'ambiente di gioco.
- **`it.dib.diadia.attrezzi`**: Implementa gli attrezzi che il giocatore può raccogliere e utilizzare.
- **`it.dib.diadia.comandi`**: Contiene la logica per interpretare ed eseguire i comandi inseriti dal giocatore.


