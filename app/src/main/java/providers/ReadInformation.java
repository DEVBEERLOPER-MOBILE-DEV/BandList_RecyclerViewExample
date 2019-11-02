package providers;

import java.util.ArrayList;

import model.Band;

public class ReadInformation {



    public ArrayList<Band> getAllBandsInTown () {
       // Band(String bandName, String bandGenre, String bandDescription, int bandMusicNumber)
        Band fooFigthers = new Band ("Foo Fighters", "Post-grunge", "Foo Fighters es una banda estadounidense de rock alternativo formada en la ciudad de Seattle en 1994 por Dave Grohl, exbaterista de Nirvana y Scream.", 6);
        Band theKillers = new Band ("The Killers", "Indie Rock", "The Killers es una banda de rock estadounidense formada en 2001 en Las Vegas (Nevada) por el vocalista, teclista y bajista Brandon Flowers y el guitarrista Dave Keuning.", 4);
        Band theOffspring = new Band ("The Offspring", "Post-grunge", "The Offspring es una banda de punk rock estadounidense, formada en Huntington Beach, California, en 1984 bajo el nombre de Manic Subsidal.", 4);
        ArrayList <Band>listOfBands = new ArrayList<Band>();
        listOfBands.add(fooFigthers);
        listOfBands.add(theKillers);
        listOfBands.add(theOffspring);

        return listOfBands;
    }

}
