package com.kmlwriter.kjw.myway;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kmlwriter.kjw.myway.const_string.ConstString;
import com.kmlwriter.kjw.myway.model.adapter.mystory.MyStoryAdapter;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.BaseObject;
import com.kmlwriter.kjw.myway.model.realmModel.RealmUser;
import com.kmlwriter.kjw.myway.model.rest_api.v1.ArticlesAPI;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Article;
import com.kmlwriter.kjw.myway.realm.RealmConfig;

import java.util.ArrayList;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyStoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyStoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyStoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String TAG = "MyStoryFragment";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static ArticlesAPI ArticlesApi;
    private RecyclerView MyStoryRecyclerView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private View rootView;
    private MyStoryAdapter adapter;

    public MyStoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyStoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyStoryFragment newInstance(String param1, String param2) {
        MyStoryFragment fragment = new MyStoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private void InitPage() {
        Realm realm = Realm.getInstance(RealmConfig.newInstance());
        RealmUser user = realm.where(RealmUser.class).findFirst();
        ArticlesApi = ServiceGenerator.createRetrofitService(ArticlesAPI.class);
        Log.e(TAG,user.toString());
        Call<ArrayList<Article>> call = ArticlesApi.ArticleSearch(user.getAccessToken(),user.getNick(),user.getApp(),user.getAppId(), ConstString.FIRST_PAGE_NO);
        realm.close();
        call.enqueue(new Callback<ArrayList<Article>>() {
            @Override
            public void onResponse(Call<ArrayList<Article>> call, Response<ArrayList<Article>> response) {
                ArrayList<Article> articles = adapter.getmArticles();
                for(Article article : response.body()){
                    articles.add(article);
                }
                adapter.setmArticles(articles);
                MyStoryRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Article>> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        MyStoryRecyclerView = (RecyclerView)rootView.findViewById(R.id.MyStoryRecyclerView);
        MyStoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyStoryAdapter(this.getContext(),savedInstanceState);
        InitPage();
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
