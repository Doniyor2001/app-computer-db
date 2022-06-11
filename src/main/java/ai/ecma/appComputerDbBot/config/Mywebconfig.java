package ai.ecma.appComputerDbBot.config;

import ai.ecma.appComputerDbBot.service.BotService;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ai.ecma.appComputerDbBot.service","ai.ecma.appComputerDbBot.controller"})
public class Mywebconfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver myViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @SneakyThrows
    @Bean
    public BotService mainService(){
        BotService botService = new BotService();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(botService);
        return botService;
    }

}
