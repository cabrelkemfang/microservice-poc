package com.techprimers.stock.dbservice.resource;


import com.techprimers.stock.dbservice.model.Quote;
import com.techprimers.stock.dbservice.model.Quotes;
import com.techprimers.stock.dbservice.repository.QuoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private QuoteRepository quoteRepository;

    public DbServiceResource(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username")final String username) {

        return getQuotesByUserName(username);
    }


    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes){

        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUserName(),quote))
                .forEach(quote ->quoteRepository.save(quote));

        return getQuotesByUserName(quotes.getUserName());

    }


  /*  @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username){

        List<Quote> quotes = quoteRepository.findByUserName(username);

        quoteRepository.delete(quotes);

        return getQuotesByUserName(username);
    }
*/

    public List<String> getQuotesByUserName(@PathVariable("username")final String username) {
        return quoteRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());

    }


}
