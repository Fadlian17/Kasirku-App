package com.alfansyah.android.kasirapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.alfansyah.android.kasirapp.Adapter.BelanjaanDataAdapter;
import com.alfansyah.android.kasirapp.MainActivity;
import com.alfansyah.android.kasirapp.Model.Belanjaan;
import com.alfansyah.android.kasirapp.R;
import com.alfansyah.android.kasirapp.Widget.EditorDialog;
import com.alfansyah.android.kasirapp.Widget.inputProdukScanner;
import com.alfansyah.android.kasirapp.tableBelanjaan;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.listeners.TableDataLongClickListener;

public class belanjaFragment extends Fragment {

    public static TextView totaljum;
    public static BottomSheetBehavior bottomSheetBehavior;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.belanja, container, false);
        tableBelanjaan belanjain=(tableBelanjaan) v.findViewById(R.id.belanjaan);
        belanjain.setDataAdapter(MainActivity.dataBalanjaan);
        belanjain.addDataClickListener(new DtaClickListener());
        belanjain.addDataLongClickListener(new DataLongClickListener());
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fabshop=(FloatingActionButton) view.findViewById(R.id.fab_shopping);
        totaljum=(TextView) view.findViewById(R.id.totaljumlah);
        bottomSheetBehavior = BottomSheetBehavior.from(view.findViewById(R.id.bottomSheet));

        fabshop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View p1) {
                new inputProdukScanner(p1.getContext()).shoping();
            }
        });

        if(BelanjaanDataAdapter.total!=0){
            totaljum.setText("Rp. "+BelanjaanDataAdapter.PRICE_FORMATTER.format(BelanjaanDataAdapter.total));
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }else{
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }
    private class DtaClickListener implements TableDataClickListener<Belanjaan> {
        @Override
        public void onDataClicked(int p1, Belanjaan belanjaan) {

            //new inputProdukScanner(getActivity()).shoping();
            new EditorDialog(getActivity(), belanjaan, totaljum);
        }
    }
    private class DataLongClickListener implements TableDataLongClickListener<Belanjaan> {
        @Override
        public boolean onDataLongClicked(int rowIndex, Belanjaan belanjaan) {
            //showdlg(belanjaan.getProduk().getNama(), belanjaan.getProduk().getHarga(), belanjaan.getQuantity());
            return true;
        }
    }
}
