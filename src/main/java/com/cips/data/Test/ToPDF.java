package com.cips.data.Test;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;

public class ToPDF {
    public static void main(String[] args) {
        //加载文档
        Document document = new Document();
        document.loadFromFile("D:\\test.docx");
        //保存
        document.saveToFile("out/pdf.pdf",FileFormat.PDF);
    }
}
