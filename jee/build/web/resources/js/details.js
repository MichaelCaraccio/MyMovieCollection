
        $( document ).ready(function() {
            coucou(getParameterByName('id'));
        });

        function coucou()
        {
            var config = "http://api.themoviedb.org/3/configuration?api_key=d4a2b2b22e65297b80e7f54ca6c21303";

            $.getJSON(config, myCallback)
                .done(function( data ) {
                return data;
            });
        };

        function myCallback(data){
            // Do some processing!
            var baseurl = data.images.base_url;
            var size = data.images.poster_sizes[4];

            var flickerAPI = "https://api.themoviedb.org/3/movie/"+getParameterByName('id')+"?api_key=d4a2b2b22e65297b80e7f54ca6c21303&language=fr";
            $.getJSON(flickerAPI)

                .done(function( data ) {
                $('.corner-title').html(""+data.genres[0].name+"");
                $('.movie-title').html("<b>"+data.title+"</b>");
                $('.cover').attr('src', baseurl+size+data.backdrop_path);
                $('.movie-synopsis').html(""+data.overview+"");
                
                $('#form_title').val(""+data.title+"");
                
                $('#form_released').val(""+data.release_date+"");
                $('#form_runtime').val(""+data.runtime+"");
                $('#form_genre').val(""+data.genres[0].name+"");
                $('#form_plot').val(""+data.overview+"");
                $('#form_poster').val(""+baseurl+size+data.backdrop_path+"");
                $('#form_imdbRating').val(""+data.vote_average+"");
                $('#form_imdbVotes').val(""+data.vote_count+"");
                $('#form_imdbId').val(""+data.imdb_id+"");
               
                
                
                
               // document.getElementById('myForm:hidden1').value = "coucou";
            
                if(data.budget === 0)
                    data.budget = "Unknown";

                $('.movie-budget').html(""+data.budget+" $");
                $('.movie-original_title').html(""+data.original_title+"");
                $('.movie-release_date').html(""+data.release_date+"");
            });
        };

        function getParameterByName(name) {
            name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
            var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.search);
            return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
        }