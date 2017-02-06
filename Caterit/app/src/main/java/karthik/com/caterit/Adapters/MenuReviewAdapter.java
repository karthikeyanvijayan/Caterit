package karthik.com.caterit.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import karthik.com.caterit.Models.Reviews;
import karthik.com.caterit.R;
import karthik.com.caterit.RestaurantManager;

/**
 * Created by user on 06/02/2017.
 */

public class MenuReviewAdapter extends RecyclerView.Adapter<MenuReviewAdapter.ReviewsViewHolder> {

    private Context context;
    ArrayList<Reviews> reviewsList;

    public MenuReviewAdapter(Context mContext) {
        this.context = mContext;
        reviewsList = (ArrayList<Reviews>) RestaurantManager.Instance().getAllReviews(this.context);
    }

    @Override
    public ReviewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_reviews, parent, false);
        return new MenuReviewAdapter.ReviewsViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ReviewsViewHolder holder, int position) {

        Reviews review = (Reviews) reviewsList.get(position);
        if (review != null) {
            holder.tvTitle.setText(review.getTitle().toString());
            holder.tvDesc.setText(review.getReviewDesc().toString());
            holder.ratingBar.setRating(review.getRating());
        }
    }

    @Override
    public int getItemCount() {
        return reviewsList.size();
    }

    public class ReviewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvTitle, tvDesc;
        public RatingBar ratingBar;

        public ReviewsViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.rvTitle);
            tvDesc = (TextView) view.findViewById(R.id.rvDesc);
            ratingBar = (RatingBar) view.findViewById(R.id.rvRatingBar);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
