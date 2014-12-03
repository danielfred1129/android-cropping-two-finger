package com.android.camera.example;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class CameraActivity extends Activity {

    private static final int CAMERA_REQUEST = 1888;
    Intent cameraIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_camera);
        
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
            Intent mainActivity = new Intent(CameraActivity.this, MainActivity.class);
//            mainActivity.putExtra("image", data.getData());
            mainActivity.setData(data.getData());
            CameraActivity.this.startActivity(mainActivity);
            CameraActivity.this.finish();
            
//            try {
//                // call the standard crop action intent (the user device may not
//                // support it)
//                Intent cropIntent = new Intent("com.android.camera.action.CROP");
//                // indicate image type and Uri
//                cropIntent.setDataAndType(data.getData(), "image/*");
//                // set crop properties
//                cropIntent.putExtra("crop", "true");
//                // indicate aspect of desired crop
//                cropIntent.putExtra("aspectX", 1);
//                cropIntent.putExtra("aspectY", 1);
//                // indicate output X and Y
//                cropIntent.putExtra("outputX", 256);
//                cropIntent.putExtra("outputY", 256);
//                // retrieve data on return
//                cropIntent.putExtra("return-data", true);
//                // start the activity - we handle returning in onActivityResult
//                startActivityForResult(cropIntent, 0);
//            }
//            // respond to users whose devices do not support the crop action
//            catch (ActivityNotFoundException anfe) {
//                Toast toast = Toast
//                        .makeText(this, "This device doesn't support the crop action!", Toast.LENGTH_SHORT);
//                toast.show();
//            }
        }
    }
}
