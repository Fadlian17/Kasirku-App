package com.alfansyah.android.kasirapp;

import android.content.Context;
import android.util.AttributeSet;

import androidx.core.content.ContextCompat;

import com.alfansyah.android.kasirapp.Model.Produk;

import java.util.Comparator;

import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import de.codecrafters.tableview.toolkit.SortStateViewProviders;
import de.codecrafters.tableview.toolkit.TableDataRowBackgroundProviders;

public class TableKu extends SortableTableView {

    public TableKu(Context context) {
        super(context, null);
    }

    public TableKu(final Context context,final AttributeSet attributes) {
        this(context, attributes, android.R.attr.listViewStyle);
    }

    public TableKu(final Context context, final AttributeSet attributes, final int styleAttributes) {
        super(context, attributes, styleAttributes);
        setColumnCount(3);
        SimpleTableHeaderAdapter simpleTableHeaderAdapter = new SimpleTableHeaderAdapter(context, "Produk", "Harga","Stok");
        simpleTableHeaderAdapter.setTextColor(ContextCompat.getColor(context, R.color.table_header_text));
        final int rowColorEven = ContextCompat.getColor(context, R.color.table_data_row_even);
        final int rowColorOdd = ContextCompat.getColor(context, R.color.table_data_row_odd);
        setDataRowBackgroundProvider(TableDataRowBackgroundProviders.alternatingRowColors(rowColorEven, rowColorOdd));
        setHeaderSortStateViewProvider(SortStateViewProviders.brightArrows());
        setHeaderAdapter(simpleTableHeaderAdapter);
        setColumnComparator(1, new HargaProdukComparator());
        setColumnComparator(0, new NamaProdukComparator());
        setColumnComparator(2, new StokProdukComparator());
    }

    private static class HargaProdukComparator implements Comparator<Produk> {
        @Override
        public int compare(Produk prod1, Produk prod2) {
            if (prod1.getHarga() < prod2.getHarga()) return -1;
            if (prod1.getHarga() > prod2.getHarga()) return 1;
            return 0;
        }
    }
    private static class StokProdukComparator implements Comparator<Produk> {
        @Override
        public int compare(Produk prod1, Produk prod2) {
            if (prod1.getStok() < prod2.getStok()) return -1;
            if (prod1.getStok()> prod2.getStok()) return 1;
            return 0;
        }
    }
    private static class NamaProdukComparator implements Comparator<Produk> {

        @Override
        public int compare(final Produk prod1, final Produk prod2) {
            return prod1.getNama().compareTo(prod2.getNama());
        }
    }
}
