package karthik.com.caterit.Models;

/**
 * Created by user on 06/02/2017.
 */

public class Reviews {

    String title,reviewDesc,datePosted;
    Integer rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "title='" + title + '\'' +
                ", reviewDesc='" + reviewDesc + '\'' +
                ", datePosted='" + datePosted + '\'' +
                ", rating=" + rating +
                '}';
    }
}
