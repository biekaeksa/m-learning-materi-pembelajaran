# m-learning-materi-pembelajaran
**Fungsi Menampilkan Gambar**

        //Untuk load image
        ImageLoader.load(context, "www.testimage.com/image.jpg", imageView);
        
        //Untuk load image dengan cache
        ImageLoader.loadWithCache(context, "www.testimage.com/image.jpg", imageView);
        
        
        
**Fungsi Menampilkan Video**

Menampilkan Video menggunakan pemutar video (VideoView)

      VideoView videoView = findViewById(R.id.video);
      VideoLoader videoLoader = new VideoLoader(this);
      
      //untuk load video menggunakan url
      videoLoader.playVideo("www.testvideo.com/belajar.mp4", videoView);
      
      
Menampilkan Video menggunakan pemutar video dari youtube (YoutubePlayerView)
      
      YoutubePlayerView youtubePlayerView = findViewById(R.id.youtube);
      VideoLoader videoLoader = new VideoLoader(this);
      
      //untuk load video menggunakan youtube
      videoLoader.playVideo("iaskjkja", youtubePlayerView);
