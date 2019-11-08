//package com.alfansyah.android.kasirapp.Fragment;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.coordinatorlayout.widget.CoordinatorLayout;
//import androidx.fragment.app.Fragment;
//
//import com.alfansyah.android.kasirapp.Adapter.ProdukDataAdapter;
//import com.alfansyah.android.kasirapp.MainActivity;
//import com.alfansyah.android.kasirapp.Model.Produk;
//import com.alfansyah.android.kasirapp.R;
//import com.alfansyah.android.kasirapp.TableKu;
//import com.alfansyah.android.kasirapp.Widget.ProdukDialog;
//import com.alfansyah.android.kasirapp.Widget.inputProdukScanner;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;
//import com.kennyc.bottomsheet.BottomSheetListener;
//import com.kennyc.bottomsheet.BottomSheetMenuDialogFragment;
//
//import de.codecrafters.tableview.listeners.TableDataClickListener;
//import de.codecrafters.tableview.listeners.TableDataLongClickListener;
//
//public class produkFragment extends Fragment {
//
//    FloatingActionButton fab_addbtn;
//    CoordinatorLayout mycoor;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View v=inflater.inflate(R.layout.myproduct, container, false);
//        fab_addbtn=(FloatingActionButton) v.findViewById(R.id.fab_addproduct);
//        TableKu tableView = (TableKu) v.findViewById(R.id.tableView);
//
//        tableView.setDataAdapter(MainActivity.dataproduk);
//        tableView.addDataClickListener(new DataClickListener());
//        tableView.addDataLongClickListener(new DataLongClickListener());
//        fab_addbtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View p1) {
//                //new ProdukDialog(getActivity(), null);
//                //new inputProdukScanner(getActivity()).tambahkanProduk();
//                new BottomSheet.Builder(getActivity())
//                        .setSheet(R.menu.inputmodemenu)
//                        .setListener(new BottomSheetListener(){
//
//                            @Override
//                            public void onSheetShown(Button p1) {
//                                // TODO: Implement this method
//                            }
//
//                            @Override
//                            public void onSheetItemSelected(BottomSheet p1, MenuItem p) {
//
//                            }
//
//                            @Override
//                            public void onSheetDismissed(@NonNull BottomSheetMenuDialogFragment bottomSheet, @Nullable Object object, int dismissEvent) {
//                                switch(p2.getItemId()){
//                                    case R.id.tambahsatuan:
//                                        new ProdukDialog(getActivity(), null);
//                                        break;
//                                    case R.id.tambahbanyak:
//                                        new inputProdukScanner(getActivity()).tambahkanProduk();
//                                        break;
//                                }
//                            }
//
//                            @Override
//                            public void onSheetShown(BottomSheet p1) {
//                                // TODO: Implement this method
//                            }
//
//                            @Override
//                            public void onSheetItemSelected(BottomSheet p1, MenuItem p2) {
//                                switch(p2.getItemId()){
//                                    case R.id.tambahsatuan:
//                                        new ProdukDialog(getActivity(), null);
//                                        break;
//                                    case R.id.tambahbanyak:
//                                        new inputProdukScanner(getActivity()).tambahkanProduk();
//                                        break;
//                                }
//                            }
//
//                            @Override
//                            public void onSheetDismissed(BottomSheet p1, int p2) {
//                                // TODO: Implement this method
//                            }
//                        }).show();
//            }
//        });
//        return v;
//    }
//
//}
