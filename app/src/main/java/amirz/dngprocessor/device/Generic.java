package amirz.dngprocessor.device;

import android.util.Rational;
import android.util.SparseArray;

import amirz.dngprocessor.parser.TIFFTag;

public class Generic implements DeviceMap.Device {
    @Override
    public boolean isModel(String model) {
        return true;
    }

    @Override
    public void neutralPointCorrection(SparseArray<TIFFTag> tags, Rational[] neutral) {
    }

    @Override
    public float histFactor(SparseArray<TIFFTag> tags) {
        return 0.2f;
    }

    @Override
    public float sharpenFactor(SparseArray<TIFFTag> tags) {
        return 0.325f;
    }

    @Override
    public float[] postProcCurve(SparseArray<TIFFTag> tags) {
        // 0 to 1, where 0 is crunchy and 1 is linear.
        /*float curveFactor = 0.33f;
        return new float[] {
                -2f + 2f * curveFactor,
                3f - 3f * curveFactor,
                curveFactor,
                0f
        };*/

        // Crush shadows
        return new float[] {
            -1f,
            2f,
            0f,
            0f
        };
    }
}