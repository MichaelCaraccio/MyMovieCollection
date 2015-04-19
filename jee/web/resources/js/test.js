

                // Variables globales
                var prodPage; 
                var totalPage;
                var prodId;
                var config = "http://api.themoviedb.org/3/configuration?api_key=d4a2b2b22e65297b80e7f54ca6c21303";
                var queryWord;
                
                $( document ).ready(function() {

                    $('.container').hide();

                    prodId = getParameterByName('id');
                    prodPage = 1;
                    if (getParameterByName('page') !== null && getParameterByName('page') !== ""){
                        prodPage = getParameterByName('page');
                    }

                    $('.container').show();

                    switch(prodId) 
                    {
                        case "nowplaying":
                            nowplaying();
                            break;
                        case "top_rated":
                            top_rated();
                            break;
                        case "upcoming":
                            upcoming();
                            break;
                        case "popular":
                            popular();
                            break;
                        case "search":
                            search();
                            break;
                        default:
                            prodId = "nowplaying";
                            nowplaying();
                    }
                });

                // Begin SEARCH
                var button = document.getElementById("search");
                button.addEventListener("keyup", function(e) {
                    if (e.keyCode === 13)
                    {
                        var url = "?id=search&page=1&query="+document.getElementById("search").value;
                        window.location.replace(url);
                    }

                });
                // End SEARCH
                function nowplaying(){
                    $('.titlebar').html("Now Playing");
                    var query = "http://api.themoviedb.org/3/movie/now_playing?api_key=d4a2b2b22e65297b80e7f54ca6c21303&page="+prodPage;
                    $.getJSON(config, null)
                        .done(function(data) {
                        multipleQuery(data,query);
                        return data;
                    });
                };
                function top_rated(){
                    $('.titlebar').html("Top Rated");
                    var query = "http://api.themoviedb.org/3/movie/top_rated?api_key=d4a2b2b22e65297b80e7f54ca6c21303&page="+prodPage;
                    $.getJSON(config, null)
                        .done(function(data) {
                        multipleQuery(data,query);
                        return data;
                    });
                };
                function upcoming(){
                    $('.titlebar').html("Upcoming movies");
                    var query = "http://api.themoviedb.org/3/movie/upcoming?api_key=d4a2b2b22e65297b80e7f54ca6c21303&page="+prodPage;
                    $.getJSON(config, null)
                        .done(function(data) {
                        multipleQuery(data,query);
                        return data;
                    });
                };
                function popular(){
                    $('.titlebar').html("Popular");
                    var query = "http://api.themoviedb.org/3/movie/popular?api_key=d4a2b2b22e65297b80e7f54ca6c21303&page="+prodPage;                       $.getJSON(config, null)
                        .done(function(data) {
                        multipleQuery(data,query);
                        return data;
                    });
                };
                function search(){
                    $('.titlebar').html("Search");

                    queryWord = document.getElementById("search").value;

                    if (document.getElementById("search").value === "" || document.getElementById("search").value === null)
                    {
                        queryWord = getParameterByName('query');
                    }

                    var query = "http://api.themoviedb.org/3/search/movie?query="+queryWord+"&api_key=d4a2b2b22e65297b80e7f54ca6c21303&page="+prodPage;
                    $.getJSON(config, null)
                        .done(function(data) {
                        multipleQuery(data,query);
                        return data;
                    });
                };

               
                function multipleQuery(data,query){
                    // Do some processing!
                    var baseurl = data.images.base_url;
                    var size = data.images.poster_sizes[4];

                    $.getJSON(query)

                        .done(function( data ) {
                        totalPage = data.total_pages;
                        makePagination();

                        $('#contentbar').html("");
                        $('#totalmovies').html("<p>"+data.total_results +" results - Page "+prodPage+"</p>");
                        $.each( data.results, function( i, item ) {

                            if (item.poster_path !== null){
                                $('#contentbar').append("<div class='col-sm-6 col-md-4 card'><div class='thumbnail'><img src="+baseurl+size+item.poster_path+"><h4>"+item.original_title+"</h4><p>Date de sortie: <b>"+item.release_date+"</b></p><center><p><a href=detailsview.xhtml?id="+item.id+" class='btn btn-default' role='button'>Détails</a></p></center></div></div>");}
                        });
                    });
                };

                function getParameterByName(name) {
                    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
                    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                        results = regex.exec(location.search);
                    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
                }

                function makePagination(){
                    
                    var searchString = "";
                    
                    if (queryWord !== undefined){
                        searchString = "&query="+queryWord;
                    }
                    
                    if (prodPage === 1 && totalPage === 1)
                    {
                        $('.pagination').html("<span class='page dark active'>1</span>");
                    }
                    else if(prodPage === 1 && totalPage > 1)
                    {
                        $('.pagination').html("<span class='page dark active'>1</span><a href='?id="+prodId+"&page="+(parseInt(prodPage, 10) + 1)+""+searchString+"' class='page dark'>Next</a><a href='?id="+prodId+"&page="+totalPage+""+searchString+"' class='page dark'>Last</a>");
                    }
                    else if(prodPage > 1 && prodPage <totalPage){
                        $('.pagination').html("<a href='?id="+prodId+"&page=1"+searchString+"' class='page dark'>First</a><a href='?id="+prodId+"&page="+(prodPage-1)+""+searchString+"' class='page dark'>Previous</a><span class='page dark active'>"+prodPage+"</span><a href='?id="+prodId+"&page="+(parseInt(prodPage, 10) + 1)+""+searchString+"' class='page dark'>Next</a><a href='?id="+prodId+"&page="+totalPage+""+searchString+"' class='page dark'>Last</a>");
                    }

                    else if(prodPage === totalPage){
                        $('.pagination').html("<a href='?id="+prodId+"&page=1"+searchString+"' class='page dark'>First</a><a href='?id="+prodId+"&page="+(prodPage-1)+""+searchString+"' class='page dark'>Previous</a><span class='page dark active'>"+prodPage+"</span>");
                    }else{
                        $('.pagination').html();
                    }
                }
