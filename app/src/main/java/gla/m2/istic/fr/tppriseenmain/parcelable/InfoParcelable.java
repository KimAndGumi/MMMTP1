package gla.m2.istic.fr.tppriseenmain.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nirina on 19/01/17.
 */

public class InfoParcelable implements Parcelable {

    String nom;
    String prenom;
    String ville;
    String date;

    public InfoParcelable(String nom, String prenom, String ville, String date){
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.date = date;
    }

    protected InfoParcelable(Parcel in) {
        nom = in.readString();
        prenom = in.readString();
        ville = in.readString();
        date = in.readString();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getVille() {
        return ville;
    }

    public String getDate() {
        return date;
    }

    public static final Creator<InfoParcelable> CREATOR = new Creator<InfoParcelable>() {
        @Override
        public InfoParcelable createFromParcel(Parcel in) {
            return new InfoParcelable(in);
        }

        @Override
        public InfoParcelable[] newArray(int size) {
            return new InfoParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(ville);
        dest.writeString(date);
    }
}
