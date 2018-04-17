package id.mzennis.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by meta on 17/04/18.
 */

public class VibrateFragment extends Fragment {

    public static VibrateFragment newInstance() {
        return new VibrateFragment();
    }

    private Vibrator vibrator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vibrate, container, false);

        Button btnVibrate = view.findViewById(R.id.btn_vibrate);
        btnVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(7000);
            }
        });

        Button btnEmergency = view.findViewById(R.id.btn_emergency);
        btnEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long pattern[] = {60,120,180,240,300,360,420,480};
                vibrator.vibrate(pattern, 1);
            }
        });

        Button btnStop = view.findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.cancel();
            }
        });

        return view;
    }
}