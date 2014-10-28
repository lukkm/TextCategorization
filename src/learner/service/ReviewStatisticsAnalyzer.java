package learner.service;

import java.util.ArrayList;
import java.util.List;

import learner.model.Review;

public class ReviewStatisticsAnalyzer {

	private List<Review> reviews = new ArrayList<Review>();
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
}
