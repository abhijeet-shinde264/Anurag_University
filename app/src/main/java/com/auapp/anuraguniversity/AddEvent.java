package com.auapp.anuraguniversity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import id.zelory.compressor.Compressor;

public class AddEvent extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    String s1,s2,s3,s4,s5,s6,s7;
    ImageView i1;
    Button b1,b2;
    FirebaseAuth auth;
    Events events;
    String postdate,posttime,postrandomname;
    private Bitmap compressedImageFile=null;
    private Uri imgUrl = null;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    int minteger = 0;
    private StorageTask mUploadTask;
    private static final int PICK_IMAGE_REQUEST = 1;

    private static final int CHOOSE_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        auth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Events");
        mStorageRef = FirebaseStorage.getInstance().getReference();
        e1 = findViewById(R.id.edacmeventname);
        e2 = findViewById(R.id.edacmdate);
        e3 = findViewById(R.id.edacmprofile);
        e4 = findViewById(R.id.edacmtarget);
        e5 = findViewById(R.id.edacmlink);
        e6 = findViewById(R.id.edacmlink1);
        e7 = findViewById(R.id.edacmlink2);
        b1 = findViewById(R.id.bacmupload);
        b2 = findViewById(R.id.bacminsert);
        i1 = findViewById(R.id.imgacm);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
            private void updateLabel() {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                e2.setText(sdf.format(myCalendar.getTime()));
            }
        };
        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddEvent.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setMinCropResultSize(512, 512)
                        .setAspectRatio(1, 1)
                        .start(AddEvent.this);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString();
                s2 = e3.getText().toString();
                s3 = e4.getText().toString();
                s4 = e5.getText().toString();
                s5 = e6.getText().toString();
                //s6 = e7.getText().toString();
                if (TextUtils.isEmpty(s1)) {
                    e1.setError("Required");
                } else if (TextUtils.isEmpty(s2)) {
                    e3.setError("Required");
                } else if (TextUtils.isEmpty(s3)) {
                    e4.setError("Required");
                } else if (TextUtils.isEmpty(s4)) {
                    e5.setError("Required");
                } else if (TextUtils.isEmpty(s5)) {
                    e6.setError("Required");
                } else if (imgUrl == null) {
                    Toast.makeText(AddEvent.this, "Image is missing....", Toast.LENGTH_SHORT).show();
                } else {
                    Calendar calendardate=Calendar.getInstance();
                    SimpleDateFormat currentdate=new SimpleDateFormat("dd-MMMM-yyyy");
                    postdate=currentdate.format(calendardate.getTime());
                    Calendar calendartime=Calendar.getInstance();
                    SimpleDateFormat currenttime=new SimpleDateFormat("hh:mm a");
                    posttime=currenttime.format(calendartime.getTime());
                    postrandomname=postdate+posttime;
                    if (imgUrl != null) {
                        final StorageReference fileReference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(imgUrl));

                        mUploadTask = fileReference.putFile(imgUrl)
                                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                            @Override
                                            public void onSuccess(Uri uri) {
                                                Events upload = new Events(e1.getText().toString().trim(),e2.getText().toString().trim(),uri.toString(),e3.getText().toString().trim(),
                                                        e4.getText().toString().trim(),e5.getText().toString().trim(),e6.getText().toString().trim(),e7.getText().toString().trim());
                                                String uploadID = mDatabaseRef.push().getKey();
                                                mDatabaseRef.child(uploadID).setValue(upload);
                                                Toast.makeText(AddEvent.this, "Upload successfully", Toast.LENGTH_LONG).show();
                                                i1.setImageResource(R.drawable.imagepreview);
                                                startActivity(new Intent(AddEvent.this,EventRetrival.class));
                                            }
                                        });
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(AddEvent.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                })
                                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                                       double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
//                                       uploadProgress.setProgress((int) progress);
                                    }
                                });
                    } else {
                        Toast.makeText(AddEvent.this, "No file selected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                imgUrl = result.getUri();
                Picasso.get().load(imgUrl).networkPolicy(NetworkPolicy.OFFLINE).into(i1);
                File crop_path=new File(imgUrl.getPath());
                try {
                    compressedImageFile=new Compressor(this)
                            .setMaxHeight(300)
                            .setMaxWidth(300).setQuality(100).compressToBitmap(crop_path);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}