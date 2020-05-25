package com.example.wednesdayapp.utils.roomdatabase;

import androidx.annotation.ColorInt;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "WEDNESDAY_TABLE")
public class WednsedayTable {
    @PrimaryKey(autoGenerate = true)
    int colomId;

    @ColumnInfo(name = "WRAPPER_TYPE")
    String wrapperType;

    @ColumnInfo(name = "KIND")
    String kind;

    @ColumnInfo(name = "ARTIEST_ID")
    String artistId;

    @ColumnInfo(name = "TRACK_ID")
    String trackId;

    @ColumnInfo(name = "ARTIEST_NAME")
    String artistName;

    @ColumnInfo(name = "COLLECTION_NAME")
    String collectionName;

    @ColumnInfo(name = "TRACK_NAME")
    String trackName;

    @ColumnInfo(name = "COLLECTION_SENSOR_NAME")
    String collectionCensoredName;

    @ColumnInfo(name = "TRACK_CENSORED_NAME")
    String trackCensoredName;

    @ColumnInfo(name = "ARTIST_VIEW_URL")
    String artistViewUrl;

    @ColumnInfo(name = "COLLECTION_VIEW_URL")
    String collectionViewUrl;

    @ColumnInfo(name = "TRACK_VIEW_URL")
    String trackViewUrl;

    @ColumnInfo(name = "PREVIEW_URL")
    String previewUrl;

    @ColumnInfo(name = "ARTWORK_URL_30")
    String artworkUrl30;

    @ColumnInfo(name = "ARTWORK_URL_60")
    String artworkUrl60;

    @ColumnInfo(name = "ARTWORK_URL_100")
    String artworkUrl100;

    @ColumnInfo(name = "COLLECTION_PRICE")
    String collectionPrice;

    @ColumnInfo(name = "TRACK_PRICE")
    String trackPrice;

    @ColumnInfo(name = "RELEASE_DATE")
    String releaseDate;

    @ColumnInfo(name = "COLLECTION_EXP")
    String collectionExplicitness;

    @ColumnInfo(name = "TRACK_EXP")
    String trackExplicitness;

    @ColumnInfo(name = "DISCOUNT")
    String discCount;

    public int getColomId() {
        return colomId;
    }

    public void setColomId(int colomId) {
        this.colomId = colomId;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(String collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public String getDiscCount() {
        return discCount;
    }

    public void setDiscCount(String discCount) {
        this.discCount = discCount;
    }

    public String getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(String discNumber) {
        this.discNumber = discNumber;
    }

    public String getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(String trackCount) {
        this.trackCount = trackCount;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(String trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public boolean isStreamable() {
        return isStreamable;
    }

    public void setStreamable(boolean streamable) {
        isStreamable = streamable;
    }

    @ColumnInfo(name = "DISC_NUMBER")
    String discNumber;

    @ColumnInfo(name = "TRACK_COUNT")
    String trackCount;

    @ColumnInfo(name = "TRACK_NUMBER")
    String trackNumber;

    @ColumnInfo(name = "TRACK_TIME_MILLS")
    String trackTimeMillis;

    @ColumnInfo(name = "COUNTRY")
    String country;

    @ColumnInfo(name = "CURRENCY")
    String currency;

    @ColumnInfo(name = "PREIMARY_GENRENAME")
    String primaryGenreName;

    @ColumnInfo(name = "IS_STREAMABLE")
    boolean isStreamable;

}
