package com.example.lectuers;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.core.content.ContextCompat.getSystemService;

public class Pdf_Adapter extends RecyclerView.Adapter<Pdf_Adapter.Holder> {
    private List<Pdf_Model>list;
    private Context context;
    ItemClickListener itemClickListener;

    public Pdf_Adapter(List<Pdf_Model> list, Context context, ItemClickListener itemClickListener) {
        this.list = list;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public Pdf_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pdf_item,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final Pdf_Adapter.Holder holder, final int position) {
    holder.pdfname.setText(list.get(position).getPdfname());
    holder.pdf_download.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if( list.get(position).getPdfname().equals("ادارة الاعمال")){
                DownloadPdf("https://bobcarp.files.wordpress.com/2014/07/code-charles-petzold.pdf","ادارة الاعمال");
            }
            //
                if(list.get(position).getPdfname().equals("علوم الشبكات")){
                Toast.makeText(context, "b", Toast.LENGTH_SHORT).show();
            }
            if(list.get(position).getPdfname().equals("اساليب برمجة")){
                DownloadPdf("https://www.pdf995.com/samples/pdf.pdf","اساليب برمجة");
            }
        }
    });
    }
    public void DownloadPdf(String url,String title){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        String temptitle = title.replace("","");
        request.setTitle(temptitle);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB){
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,temptitle+".pdf");
        DownloadManager downloadManager =(DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        request.setMimeType("application/pdf");
        request.allowScanningByMediaScanner();

        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        downloadManager.enqueue(request);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView;
        private TextView pdfname,pdf_download;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_pdf);
            pdfname=itemView.findViewById(R.id.text_pdf);
            pdf_download =itemView.findViewById(R.id.text_pdf_download);
           imageView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
          itemClickListener.onclick(v,getAdapterPosition(),false);
        }
    }
}
