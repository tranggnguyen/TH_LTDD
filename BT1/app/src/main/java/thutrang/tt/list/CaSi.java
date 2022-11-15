package thutrang.tt.list;

import android.media.Image;

public class CaSi {
    String title;
    String content;
    String sosao;
    int img;
    String quocGia;

    public CaSi(String title, String content, String sosao, int img, String quocGia) {
        this.title = title;
        this.content = content;
        this.sosao = sosao;
        this.img = img;
        this.quocGia = quocGia;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSosao() {
        return sosao;
    }

    public void setSosao(String sosao) {
        this.sosao = sosao;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
}

