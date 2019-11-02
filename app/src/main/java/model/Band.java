package model;

/**
 * Model Class  Of a Band
 */
public class Band {


    private String bandName;
    private String bandGenre;
    private String bandDescription;
    private int bandMusicNumber;

    public Band() {
    }

    /**
     * Constructor
     * @param bandName
     * @param bandGenre
     * @param bandDescription
     * @param bandMusicNumber
     */
    public Band(String bandName, String bandGenre, String bandDescription, int bandMusicNumber) {
        this.bandName = bandName;
        this.bandGenre = bandGenre;
        this.bandDescription = bandDescription;
        this.bandMusicNumber = bandMusicNumber;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getBandGenre() {
        return bandGenre;
    }

    public void setBandGenre(String bandGenre) {
        this.bandGenre = bandGenre;
    }

    public String getBandDescription() {
        return bandDescription;
    }

    public void setBandDescription(String bandDescription) {
        this.bandDescription = bandDescription;
    }

    public int getBandMusicNumber() {
        return bandMusicNumber;
    }

    public void setBandMusicNumber(int bandMusicNumber) {
        this.bandMusicNumber = bandMusicNumber;
    }
}
