package com.roberto.backend.challenge.books.catalog.infrastructure.adapter.repository.model;

import com.roberto.backend.challenge.books.catalog.domain.model.Book;
import com.roberto.backend.challenge.books.catalog.domain.model.value_objects.Author;
import com.roberto.backend.challenge.books.catalog.domain.model.value_objects.Genre;
import com.roberto.backend.challenge.books.catalog.domain.model.value_objects.PublishedOn;
import com.roberto.backend.challenge.books.catalog.domain.model.value_objects.Publisher;
import com.roberto.backend.challenge.books.catalog.domain.model.value_objects.Title;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class JpaBook {

  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "author", nullable = false)
  private String author;

  @Column(name = "genre", nullable = false)
  private String genre;

  @Column(name = "publisher", nullable = false)
  private String publisher;

  @Column(name = "published_on", nullable = false)
  private LocalDate publishedOn;


  public static JpaBook fromDomain(final Book book) {
    return JpaBook.builder()
        .id(book.getId().value())
        .title(book.getTitle().value())
        .author(book.getAuthor().value())
        .genre(book.getGenre().value())
        .publisher(book.getPublisher().value())
        .publishedOn(book.getPublishedOn().value())
        .build();
  }

  public Book toDomain() {
    return Book.builder()
        .id(new com.roberto.backend.challenge.books.catalog.domain.model.value_objects.Id(id))
        .title(new Title(title))
        .author(new Author(author))
        .genre(new Genre(genre))
        .publisher(new Publisher(publisher))
        .publishedOn(new PublishedOn(publishedOn))
        .build();
  }
}
