package com.example.retrofitget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitget.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<UserListResponse> userListResponseData;
    ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        getUserListData();
    }

    private void getUserListData() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        (Api.getClient().getUsersList()).enqueue(new Callback<List<UserListResponse>>() {

            @Override
            public void onResponse(Call<List<UserListResponse>> call, Response<List<UserListResponse>> response) {
                Log.d("responseGET", response.body().get(0).getName());
                progressDialog.dismiss();
                userListResponseData = response.body();
                setDataInRecyclerView();
            }

            @Override
            public void onFailure(Call<List<UserListResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();

            }
        });
    }

    private void setDataInRecyclerView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        bind.recyclerView.setLayoutManager(linearLayoutManager);

        UserClassAdapter usersAdapter = new UserClassAdapter(MainActivity.this, userListResponseData);
        bind.recyclerView.setAdapter(usersAdapter);
    }
}

