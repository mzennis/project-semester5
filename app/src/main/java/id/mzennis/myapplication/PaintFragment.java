package id.mzennis.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

/**
 * Created by meta on 30/03/18.
 */

public class PaintFragment extends Fragment {

    public static PaintFragment newInstance() {
        return new PaintFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paint, container, false);

        final DrawableView drawableView = view.findViewById(R.id.draw_view);

        ImageButton btnErase = view.findViewById(R.id.btn_erase);
        ImageButton btnUndo = view.findViewById(R.id.btn_undo);
        ImageButton btnWrite = view.findViewById(R.id.btn_write);

        final DrawableViewConfig cfg = new DrawableViewConfig();
        cfg.setStrokeColor(getResources().getColor(android.R.color.black));
        cfg.setShowCanvasBounds(true);
        cfg.setStrokeWidth(20f);
        cfg.setMinZoom(1f);
        cfg.setMaxZoom(3f);
        cfg.setCanvasWidth(900);
        cfg.setCanvasHeight(1080);

        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawableView.undo();
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cfg.setStrokeColor(getResources().getColor(android.R.color.black));
            }
        });

        btnErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cfg.setStrokeColor(getResources().getColor(R.color.background));
            }
        });

        drawableView.setConfig(cfg);

        return view;
    }
}
