package com.example.lectuers;

public class Pdf_Model {
    private String pdfname;
    private String pdfur;
    private String pdf_download;
//download-pdf-ebooks.org-ku-17247.pdf
    public Pdf_Model(String pdfname, String pdfur,String pdf_download) {
        this.pdfname = pdfname;
        this.pdfur = pdfur;
        this.pdf_download=pdf_download;
    }

    public void setPdf_download(String pdf_download) {
        this.pdf_download = pdf_download;
    }

    public String getPdf_download() {
        return pdf_download;
    }

    public String getPdfname() {
        return pdfname;
    }

    public String getPdfur() {
        return pdfur;
    }

    public void setPdfname(String pdfname) {
        this.pdfname = pdfname;
    }

    public void setPdfur(String pdfur) {
        this.pdfur = pdfur;
    }
}
