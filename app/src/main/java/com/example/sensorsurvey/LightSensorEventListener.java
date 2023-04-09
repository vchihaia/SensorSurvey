package com.example.sensorsurvey;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class LightSensorEventListener implements SensorEventListener {
    private Context context;
    private WeakReference<TextView> mTextSensorLight;

    public LightSensorEventListener(Context context, TextView mTextSensorLightView) {
        this.context = context;
        this.mTextSensorLight = new WeakReference<>(mTextSensorLightView);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float currentValue = event.values[0];
        mTextSensorLight.get().setText(context.getResources().getString(
                R.string.label_light, currentValue));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
