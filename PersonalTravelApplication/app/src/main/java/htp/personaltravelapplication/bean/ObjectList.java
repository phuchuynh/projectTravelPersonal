package htp.personaltravelapplication.bean;

/**
 * Created by phuchtgc60244 on 3/15/2016.
 */
//file nay bat buoc phai co cho tat ca table moi them vao
     // file nay tao thanh file chung dung ko a
    //ko , vi du ne
public class ObjectList {

     public Integer id;
    public String title ;
    public String content;
    public String lng;
    public String lat;
    public String zoom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

    public ObjectList()
    {}
}
