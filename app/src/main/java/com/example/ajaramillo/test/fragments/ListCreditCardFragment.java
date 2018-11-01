package com.example.ajaramillo.test.fragments;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ajaramillo.test.R;
import com.example.ajaramillo.test.adapters.CreditCardAdapter;

import com.example.ajaramillo.test.pojo.CreditCard;


import java.util.ArrayList;
import java.util.Collections;


public class ListCreditCardFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<CreditCard> ListCreditCards;

    RecyclerView recyclerCards;

    CreditCardAdapter adapter;

    public ListCreditCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListCreditCardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListCreditCardFragment newInstance(String param1, String param2) {
        ListCreditCardFragment fragment = new ListCreditCardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Collections.addAll(ListCreditCards);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_list_credit_card, container, false);

        ListCreditCards = new ArrayList<>();

        recyclerCards = vista.findViewById(R.id.recyclerId);
        recyclerCards.setHasFixedSize(true);
        recyclerCards.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        final CreditCardAdapter adapter = new CreditCardAdapter(ListCreditCards);
        recyclerCards.setAdapter(adapter);


        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder draggred, @NonNull RecyclerView.ViewHolder target) {

                int fromPosition = draggred.getAdapterPosition();
                int toPosition = target.getAdapterPosition();


                Collections.swap(ListCreditCards, fromPosition, toPosition);
                adapter.notifyItemChanged(fromPosition, toPosition);

                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }


        });

        helper.attachToRecyclerView(recyclerCards);
        FillListCreditCards();


        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Selecciona: " + ListCreditCards
                        .get(recyclerCards.getChildAdapterPosition(v)).getName(), Toast.LENGTH_SHORT).show();
                
            }
        });



        return vista;
    }



    private void FillListCreditCards() {

        ListCreditCards.add(new CreditCard("Card 1","Information 1",R.mipmap.ic_launcher));
        ListCreditCards.add(new CreditCard("Card 2","Information 2",R.mipmap.ic_launcher));
        ListCreditCards.add(new CreditCard("Card 3","Information 3",R.mipmap.ic_launcher));
        ListCreditCards.add(new CreditCard("Card 4","Information 4",R.mipmap.ic_launcher));
        ListCreditCards.add(new CreditCard("Card 5","Information 5",R.mipmap.ic_launcher));

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
