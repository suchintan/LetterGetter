package com.awesome.lettergetter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.awesome.lettergetter.dto.User;

public class LeaderboardActivity extends MenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leaderboard);
		populateLeaderView();
	}
	
	private void populateLeaderView(){
		ArrayAdapter<User> adapter = new LeaderboardAdapter();
		ListView list = (ListView) findViewById(R.id.leaders_listview);
		
		list.setAdapter(adapter);
	}
	
	private class LeaderboardAdapter extends ArrayAdapter<User>{

		public LeaderboardAdapter() {
			super(LeaderboardActivity.this, R.layout.leader_view, gameState.getLeaderboardData());
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View leaderView = convertView;
			if (leaderView == null){
				leaderView = getLayoutInflater().inflate(R.layout.leader_view, parent, false);
			}
			//Find the leader
			User currentLeader = gameState.getLeaderboardData().get(position);
			
			//Fill the view
			//Nickname:
			TextView nickNameText = (TextView) leaderView.findViewById(R.id.leader_nickname);
			nickNameText.setText(currentLeader.getName());
			
			//Score:
			TextView scoreText = (TextView) leaderView.findViewById(R.id.leader_score);
			scoreText.setText(Integer.toString(currentLeader.getScore()));
			
			return leaderView;
		}
		
	}

}
