# m-learning-materi-pembelajaran
**Fungsi Menampilkan Gambar**

        //Untuk load image
        ImageLoader.load(context, "www.testimage.com/image.jpg", imageView);
        
        //Untuk load image dengan cache
        ImageLoader.loadWithCache(context, "www.testimage.com/image.jpg", imageView);
        
        
        
**Fungsi Menampilkan Video**

Menampilkan Video menggunakan pemutar video (VideoView)

XML

        <VideoView
                android:id="@+id/video_videoview"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_centerInParent="true"/>

Java

      VideoView videoView = findViewById(R.id.video_videoview);
      VideoLoader videoLoader = new VideoLoader(this);
      
      //untuk load video menggunakan url
      videoLoader.playVideo("www.testvideo.com/belajar.mp4", videoView);
      
      
Menampilkan Video menggunakan pemutar video dari youtube (YoutubePlayerView)

XML

        <com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView
                android:id="@+id/video_youtube"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_centerInParent="true"/>

Java
      
      YoutubePlayerView youtubePlayerView = findViewById(R.id.video_youtube);
      VideoLoader videoLoader = new VideoLoader(this);
      
      //untuk load video menggunakan youtube
      videoLoader.playVideo("iaskjkja", youtubePlayerView);

**Fungsi Restful API**

>APIServices.class

        @GET("video")
        Observable<List<CourseModel>> getListVideo();
        
>Test.class
       
        NetworkServices<List<CourseModel>> networkServices = new NetworkServices<>();
        Observable<List<CourseModel>> call = networkServices.
        urlNetwork("http://comrades-api.azurewebsites.net/v2/").create(APIServices.class)
                .getListVideo();
        networkServices.subscribe(call, new Callback<List<CourseModel>>() {
            @Override
            public void onResponse(List<CourseModel> courseModels) {
               //lakukan apabila sudah mendapatkan response
            }

            @Override
            public void onError(Throwable e) {
                //lakukan apabila terjadi error
            }
        });
